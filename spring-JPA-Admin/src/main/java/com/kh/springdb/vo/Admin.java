package com.kh.springdb.vo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="admin_Seq")
	@SequenceGenerator(name="admin_Seq", sequenceName="admin_Seq", allocationSize=1)
	private Long adminId;
	private Long adminPw;
}
