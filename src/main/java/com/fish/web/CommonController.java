package com.fish.web;

import com.fish.domain.Address;
import com.fish.domain.Family;
import com.fish.domain.Person;
import com.fish.entity.Discuss;

import com.fish.repository.DisscussRepository;
import com.fish.repository.PersonRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@Controller
@RequestMapping("common")
public class CommonController {

    //    @Autowired
//    private ArticleMapper articleMapper;

    @Autowired
    private DisscussRepository discussRepository;

    @Autowired
    private PersonRepository personRepository;
//
//    @GetMapping("/article")
//    @ResponseBody
//    public String selectArticle(Integer id) {
//        Article article = articleMapper.selectArticle(id);
//        return article.toString();
//    }

    @GetMapping("/jpaSelect")
    @ResponseBody
    public String selectDiscuss(Integer id) {
        Optional<Discuss> optional = discussRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get().toString();
        }
        return "-1";
    }

    @GetMapping("/jpaSelect2")
    @ResponseBody
    public String selectDiscussByKey() {
        List<Discuss> discusses = discussRepository.findByAuthorNotNull();
        return discusses.toString();
    }

    @GetMapping("/jpaSelect3")
    @ResponseBody
    public String selectDiscussPaged(){
        Pageable pageable = PageRequest.of(0, 3);
        List<Discuss> discusses = discussRepository.getDiscussPaged(1,pageable);
        return discusses.toString();
    }

    @GetMapping("/jpaSelect4")
    @ResponseBody
    public String selectDiscussList(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("lassafever");
        Example<Discuss> example = Example.of(discuss);
        List<Discuss> list = discussRepository.findAll(example);
        return list.toString();
    }

    @GetMapping("/jpaSelect5")
    @ResponseBody
    public String selectDiscussMatcher(){
        Discuss discuss = new Discuss();
        discuss.setAuthor("lass");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("author", startsWith());
        Example<Discuss> list = Example.of(discuss,matcher);
        return list.toString();
    }

    @GetMapping("/savePerson")
    @ResponseBody
    public String savePerson(){
        Person person = new Person("张","有才");
        Person person1 = new Person("James", "Harden");
        Address address = new Address("北京","China");
        person.setAdress(address);
        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲","张良");
        Family mom = new Family("母亲","李香君");

        list.add(dad);
        list.add(mom);

        person.setFamilyList(list);

        Person save = personRepository.save(person);
        Person save2 = personRepository.save(person1);

        return save.toString() +"\n" +save2.toString();
    }

    @GetMapping("/selectPerson")
    @ResponseBody
    public String selectPerson(String cityName){
        List<Person> list = personRepository.findByAdress_City(cityName);
        return list.toString();
    }

    @GetMapping("updatePerson")
    @ResponseBody
    public String updatePerson(){
        Person person = personRepository.findByFirstnameAndLastname("张","有才").get(0);
        person.setLastname("小明");
        Person update = personRepository.save(person);
        return update.toString();
    }

    @GetMapping("/deletePerson")
    @ResponseBody
    public void deletePerson(String fName, String lName){
        Person person = personRepository.findByFirstnameAndLastname(fName, lName).get(0);
        personRepository.delete(person);
    }

    @GetMapping("/toupload")
    public String upload(){
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model){
        model.addAttribute("uploadStatus", "上传成功！");

        for (MultipartFile file : fileUpload){
            String originalFilename = file.getOriginalFilename();

            String fileName = UUID.randomUUID() + "_" + originalFilename;

            String dirPath = "F:/file/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "upload";
    }

    @GetMapping("/toDownload")
    public String toDownload(){
        return "download";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, String filename) throws UnsupportedEncodingException {
        String dirPath = "F:/file/";

        File file = new File(dirPath + File.separator + filename);
        filename = getFilename(request, filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }

    private String getFilename(HttpServletRequest request, String filename) throws UnsupportedEncodingException {
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        for (String keyWord : IEBrowserKeyWords){
            return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
        }

        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }


}
