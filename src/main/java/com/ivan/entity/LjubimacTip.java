package com.ivan.entity;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.ivan.entity.model.ImeEntitet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LjubimacTip extends ImeEntitet{
	private static final long serialVersionUID = 1L;

	private String tip_ljubimca;
	
	@OneToMany(mappedBy = "ljubimacTip", cascade = CascadeType.ALL, orphanRemoval = true,
			fetch = FetchType.LAZY)
	private List<Ljubimac>  ljubimci;
	

	
}
