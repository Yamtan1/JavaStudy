package com.example.demo2.service;

import com.example.demo2.entity.User;
import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;


public class UserService {
    private EntityManagerFactory emf;
    private EntityManager em;

    public UserService(){
        emf = Persistence.createEntityManagerFactory("myPU");
        em = emf.createEntityManager();
    }


    public void createUser(String username, String email, Integer age){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            User user = new User(username, email, age);
            em.persist(user);
            tx.commit();

            System.out.println("사용자 생성 성공:" + user);
        }catch (Exception e){
            tx.rollback();
            System.out.println("사용자 생성 실패" + e.getMessage());
        }
    }
    public User findUserById(Long id){
        try{
            User user = em.find(User.class, id);
            if(user != null){
                System.out.println("Success find user: " + user);
            }else{
                System.out.println("ID" + id + "is not exist!");
            }
            return user;
        }catch (Exception e){
            System.out.println("Fall find user: " + e.getMessage());
            return null;
        }
    }


    // read - 모든 사용자 조회
    public List<User> findAllUsers() {
        try {
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = query.getResultList();
            System.out.println("All Users count : " + users.size());
            return users;
        } catch (Exception e) {
            System.out.println("fail......." + e.getMessage());
            return null;
        }
    }

    // update - 사용자 정보 수정
    public void updateUser(Long id, String newEmail) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User user = em.find(User.class, id);

            if(user != null) {
                user.setEmail(newEmail);
                tx.commit();
                System.out.println("Success : " + user);
            } else {
                tx.rollback();
                System.out.println("None!!");
            }

        } catch(Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        }
    }
    //READ - 특정 조건으로 사용자 조회
    public List<User> findUserByAge(Integer minAge){
        try{
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.age >= :minAge", User.class
            );
            query.setParameter("minAge", minAge);
            List<User> users = query.getResultList();
            System.out.println(minAge + "t세 이상의 사용자 수 : " + users.size());
                    return users;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //DELETE - 사용자 삭제
    public void deleteUser(Long id){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            User user = em.find(User.class, id);
            if(user != null){
                em.remove(user);
                tx.commit();
                System.out.println("사용자 삭제 완료 : " + user);
            }else{
                tx.rollback();
                System.out.println("삭제할 사용자를 찾을 수 없습니다.");
            }
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }

    //UPDATE - 준영속 엔티티 방향
    public void mergeUser(){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            User user = new User("test-user", "test@green.com",100);
            em.persist(user);
            em.clear();
            User managedUser = em.merge(user);
            tx.commit();
            System.out.println("Merged...." + managedUser);
            System.out.println(em.contains(managedUser));
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    /*
      //UPDATE - 준영속 엔티티 방향2
    public void mergeUser(){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();

            User user  = em.find(User.class, 1L);
            System.out.println(1 + ") " + em.contains(user)); //ture
            em.clear();

            System.out.println(2 + ") " + em.contains(user)); //false
            User managedUser = em.merge(user);
            System.out.println(3 + ") " + em.contains(managedUser)); //ture

            tx.commit();
            System.out.println("Merged.." + managedUser);
            System.out.println(4 + ") " + em.contains(managedUser));

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }
    */
}


