package model;

public interface CellphoneFactory {
	Phone getPhone(String phoneType);
	CellphoneFactory clone();
}
