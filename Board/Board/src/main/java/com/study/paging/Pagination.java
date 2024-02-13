package com.study.paging;

import com.study.common.dto.SearchDto;
import lombok.Getter;

@Getter
public class Pagination {
    private int totalRecordCount;
    private int totalPageCount;
    private int startPage;
    private int endPage;
    private int limiStart;
    private boolean existPrevPage;
    private boolean existNextPage;

    public Pagination(int totalRecordCount, SearchDto params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(params);
            params.setPagination(this);
        }
    }

    private void calculation(SearchDto params){
        totalPageCount = ((totalRecordCount-1)/params.getRecordSize())+1;
        if(params.getPage()> totalPageCount){
            params.setPage(totalPageCount);
        }

        startPage = ((params.getPage()-1)/params.getPageSize())*params.getPageSize()+1;
        endPage = startPage+params.getPageSize()-1;
        if(endPage>totalPageCount){
            endPage = totalPageCount;
        }
        limiStart = (params.getPage() -1)*params.getRecordSize();

        existPrevPage = startPage !=1;
        existNextPage = (endPage*params.getRecordSize()) < totalRecordCount;
    }

}
