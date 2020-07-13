package com.fish.service;

import com.fish.domain.KlassInfo;
import com.fish.repository.KlassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class KlassService {

    private final KlassRepository klassRepository;

    public List<KlassInfo> findAll(){
        return klassRepository.findAll();
    }

    public KlassInfo findById(Long id){
        return klassRepository.findById(id).orElseThrow(
                () -> {
                   return new RuntimeException("没有该班级");
                }
        );
    }

    public KlassInfo saveKlass(KlassInfo klassInfo){
        return klassRepository.save(klassInfo);
    }

    public KlassInfo updateKlass(KlassInfo klassInfo){
        return klassRepository.saveAndFlush(klassInfo);
    }

    public void deleteKlassById(Long id){
        klassRepository.deleteById(id);
    }

    public void deleteKlass(KlassInfo klassInfo){
        klassRepository.delete(klassInfo);
    }

}
