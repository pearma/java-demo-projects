package com.pearma.vuebackenddemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="systeminfo")
public class SystemInfo {

    @Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "system_id")
    private String systemId;

    @Column(name = "system_full_name")
    private String systemFullName;

    @Column(name = "system_short_name")
    private String systemShortName;

    public String toString()
    {
        return "system info";
    }
}
