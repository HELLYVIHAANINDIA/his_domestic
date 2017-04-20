package com.hisd.common.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name="tbl_columntype")
public class TblColumnType  implements java.io.Serializable {

		private   int columnTypeId;
        private   String columnName;
        private   String lang1;
        private   String lang2;
        private   String lang3;
        private   String lang4;
        private   String lang5;
        private   String lang6;
        private   String lang7;
        private   String lang8;


               public TblColumnType(){
        }

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="columnTypeId",unique=true,nullable=false)   
			public int getColumnTypeId() {
				return columnTypeId;
			}


			public void setColumnTypeId(int columnTypeId) {
				this.columnTypeId = columnTypeId;
			}

			@Column(name="columnName",unique=true,nullable=false)
			public String getColumnName() {
				return columnName;
			}


			public void setColumnName(String columnName) {
				this.columnName = columnName;
			}

			@Column(name="lang1")
			public String getLang1() {
				return lang1;
			}


			public void setLang1(String lang1) {
				this.lang1 = lang1;
			}

			@Column(name="lang2")
			public String getLang2() {
				return lang2;
			}


			public void setLang2(String lang2) {
				this.lang2 = lang2;
			}

			@Column(name="lang3")
			public String getLang3() {
				return lang3;
			}


			public void setLang3(String lang3) {
				this.lang3 = lang3;
			}

			@Column(name="lang4")
			public String getLang4() {
				return lang4;
			}


			public void setLang4(String lang4) {
				this.lang4 = lang4;
			}

			@Column(name="lang5")
			public String getLang5() {
				return lang5;
			}


			public void setLang5(String lang5) {
				this.lang5 = lang5;
			}

			@Column(name="lang6")
			public String getLang6() {
				return lang6;
			}


			public void setLang6(String lang6) {
				this.lang6 = lang6;
			}

			@Column(name="lang7")
			public String getLang7() {
				return lang7;
			}


			public void setLang7(String lang7) {
				this.lang7 = lang7;
			}

			@Column(name="lang8")
			public String getLang8() {
				return lang8;
			}


			public void setLang8(String lang8) {
				this.lang8 = lang8;
			}
               
               
               
}
