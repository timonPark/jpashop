package jpabook.jpashop.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;

	@Test
	@Transactional
	public void memberSaveAndFindTest() throws Exception {
		// given
		Member member = new Member();
		member.setUsername("박종훈");

		// when
		Long saveId = memberRepository.save(member);
		Member findMember = memberRepository.find(saveId);

		// then
		Assertions.assertEquals(findMember.getId(), member.getId());
		Assertions.assertEquals(findMember.getUsername(), member.getUsername());;
		Assertions.assertEquals(member, findMember);
	}
}