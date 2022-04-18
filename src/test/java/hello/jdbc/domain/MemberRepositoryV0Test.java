package hello.jdbc.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberRepositoryV0Test {
	
	MemberRepositoryV0 repository = new MemberRepositoryV0();

	@Test
	void crud() throws SQLException {
		//save
		Member member = new Member("memberV3", 10000);
		repository.save(member);
		
		//findById
		Member findMember = repository.findById(member.getMemberId());
		log.info("findMember={}", findMember);
		log.info("member == findMember {}", member == findMember);
		log.info("member equals findMember {}", member.equals(findMember));
		assertThat(findMember).isEqualTo(member);
	}

}
