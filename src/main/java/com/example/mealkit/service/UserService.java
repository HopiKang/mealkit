package com.example.mealkit.service;

import com.example.mealkit.dto.UsersForm;
import com.example.mealkit.entity.Users;
import com.example.mealkit.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;


/**
 * UserService
 * 유저생성이나 조회, 수정, 삭제시 유저가 있으면 중복유저다 없다면
 * 새로운 유저를 등록했다같은 정보를 클라이언트에 반환한다
 * Getter 와 Setter 를 가지고있다
 * */
@Service
@Slf4j // 로그확인
public class UserService {

    @Autowired // 초기화 되지않는 final 필드나 NonNull 이 붙은 필드에 대해 생성자를 생성해준다
    private UsersRepository usersRepository;

    /**
     * create (유저생성 service)
     * controller 에서 UserForm 을 통해 User 정보를 받아옴
     * (id, nickname, userId, userPassword, createdDate)
     * controller 를 통해 Users 를 생성할 정보를 받아오고
     * UsersRepository 를 통해 userId List 를 받아와서 중복확인
     * 중복하지 않으면 UsersRepository 를 이용해서 Entity 에 저장
     */
//    @Transactional // 실패한다면 롤백
    public Users create(UsersForm dto){
        Users users = dto.toEntity();
//        dto 로 들어온 데이터 확인
        log.info(dto.toString());
//        userRepository 를 통해 들어온 dto 정보를 저장
        return usersRepository.save(users);
    }

    /**
     * update (개인정보수정 service)
     * controller 에서 UsersForm 를 통해 Users 정보를 받아옴
     * controller 에서 userId 를 받아와서 중복확인
     * Users 정보수정이 가능한지 확인
     */
    public Users update(Long id, UsersForm dto){
        Users users = usersRepository.findById(id).orElse(null);
        log.info("id: {}, article: {}", id, users.toString());
        Users target = dto.toEntity();
        users.patch(target);
        Users updated = usersRepository.save(users);
        return updated;
    }
    /**
     * delete
     * Users
     * */
    public Users delete(Long id){
        Users target = usersRepository.findById(id).orElse(null);
        usersRepository.delete(target);
        return target;
    }

    /**
     * findList (Users 전체출력 service)
     * */
    public List<Users> findList(){
        return usersRepository.findAll();
    }

    public Users show(Long id){
        return usersRepository.findById(id).orElse(null);
    }


}
