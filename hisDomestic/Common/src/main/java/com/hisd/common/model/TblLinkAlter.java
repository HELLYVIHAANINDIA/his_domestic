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
@Table(name="URL_ALTER")
public class TblLinkAlter  implements java.io.Serializable {

		private   int id;
        private   String URL;
        private   String type;


               public TblLinkAlter(){
        }

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="id",unique=true,nullable=false)   
			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			@Column(name="URL")
			public String getURL() {
				return URL;
			}

			public void setURL(String uRL) {
				URL = uRL;
			}

			@Column(name="type")
			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

}
