package com.kh.springdb.vo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="STUDENT-MEMBER")
public class STMember {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="st_Seq")
	@SequenceGenerator(name="st_Seq", sequenceName="st_Seq", allocationSize=1)
	private Long STNumber;
	private String memberName;
	private Long KoreanScore;
	private Long englishScore;
	private Long mathScore;
}
