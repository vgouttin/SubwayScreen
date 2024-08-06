package ca.ucalgary.ensf380;

import java.util.List;

public class NewsResponse {
    private String status;
    private int totalResults;
    private List<Article> results;
    private String nextPage;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}
	public List<Article> getResults() {
		return results;
	}
	public void setResults(List<Article> results) {
		this.results = results;
	}
	public String getNextPage() {
		return nextPage;
	}
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

    // Getters and Setters

}
