package com.mortgagedemo.app.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.mortgagedemo.app.model.Mortgage;

@Repository
public class MortgageRepository implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;
	public Mortgage array[];
	private int count;
	public int size;

	@Override
	public MortgageRepository clone() throws CloneNotSupportedException {
		MortgageRepository mortgageRepository = (MortgageRepository) super.clone();
		mortgageRepository.array = this.array.clone();
		return mortgageRepository;
	}

	public MortgageRepository() {
		array = new Mortgage[1];
		count = 0;
		size = 1;
	}

	public Mortgage add(Mortgage mortgage) {
		if (count == size) {
			growSize();
		}
		array[count] = mortgage;
		count++;
		shrinkSize();
		return mortgage;
	}

	public void growSize() {

		Mortgage temp[] = null;
		if (count == size) {
			temp = new Mortgage[size * 2];
			{
				for (int i = 0; i < size; i++) {
					temp[i] = array[i];
				}
			}
		}
		array = temp;
		size = size * 2;
	}

	public void shrinkSize() {
		Mortgage temp[] = null;
		if (count > 0) {
			temp = new Mortgage[count];
			for (int i = 0; i < count; i++) {
				temp[i] = array[i];
			}
			size = count;
			array = temp;
		}
	}

	public Mortgage set(int index, Mortgage mortgage) {
		if (count == size) {
			growSize();
		}
		array[index] = mortgage;
		count++;
		shrinkSize();
		return mortgage;
	}

	/*
	 * public Mortgage addAt(int index, Mortgage mortgage) { if (count == size) {
	 * growSize(); } for (int i = count - 1; i >= index; i--) { array[i + 1] =
	 * array[i]; } array[index] = mortgage; count++; shrinkSize(); return mortgage;
	 * }
	 */

	/*
	 * public void remove() { if (count > 0) { array[count - 1] = null; count--; } }
	 */

	/*
	 * public void removeAt(int index) { if (count > 0) { for (int i = index; i <
	 * count - 1; i++) { array[i] = array[i + 1]; } array[count - 1] = null;
	 * count--; } }
	 */

	/*
	 * public void removeNull(Mortgage mortgage) { MortgageDynamicArray
	 * mortgageDynamicArray = new MortgageDynamicArray(); if (count > 0) { for (int
	 * i = 0; i < count - 1; i++) { if (array[i] != null) {
	 * mortgageDynamicArray.array[i] = array[i]; } else { i++; count--; } } } }
	 */

}
