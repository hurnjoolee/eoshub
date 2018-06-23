package io.eoshub.model;

import io.eoshub.common.Constants;
import io.eoshub.type.SortOrderType;

public class BaseCriteria {

    private Integer page = Constants.DEF_PAGE_NUMBER;

    private Integer limit = Constants.DEF_PAGE_ROW_LIMIT;

    protected String sortBy;

    protected SortOrderType sortOrder;

    private Boolean isAllSearch = Boolean.FALSE;

    public SortOrderType getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrderType sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getAllSearch() {
        return isAllSearch;
    }

    public void setAllSearch(Boolean allSearch) {
        isAllSearch = allSearch;
    }

    public Integer getOffset() {
        if (page == null || limit == null) {
            return null;
        }

        return (page - 1) * limit;
    }

    public static boolean isNotEmpty(String param) {
        if (param != null && !param.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean isEmpty(String param) {
        if (param == null || param.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * @return the page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * @return the isAllSearch
     */
    public Boolean getIsAllSearch() {
        return isAllSearch;
    }

    /**
     * @param isAllSearch the isAllSearch to set
     */
    public void setIsAllSearch(Boolean isAllSearch) {
        this.isAllSearch = isAllSearch;
    }

}
