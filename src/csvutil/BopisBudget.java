package csvutil;

import lombok.Data;

@Data
public class BopisBudget {
	int storeId;
	String fiscalWeek;
	int budget;

	public BopisBudget() {

	}

	public BopisBudget(int storeId, String fiscalWeek, int budget) {
		this.storeId = storeId;
		this.fiscalWeek = fiscalWeek;
		this.budget = budget;
	}
}
