package io.eoshub.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AdAirdrop {

	private Integer id;
	private File icon;
	private String title;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date expireDate;
	private String coinName;
	private String coinSymbol;
	private String coinDesc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getIcon() {
		return icon;
	}

	public void setIcon(File icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getCoinName() {
		return coinName;
	}

	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}

	public String getCoinSymbol() {
		return coinSymbol;
	}

	public void setCoinSymbol(String coinSymbol) {
		this.coinSymbol = coinSymbol;
	}

	public String getCoinDesc() {
		return coinDesc;
	}

	public void setCoinDesc(String coinDesc) {
		this.coinDesc = coinDesc;
	}

}
