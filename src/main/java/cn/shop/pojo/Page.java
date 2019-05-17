package cn.shop.pojo;

public class Page {
    private Integer currentNo = 1;
    private Integer pagetotalCount;
    private Integer PageSize = 5;
    private Integer PageCount;

    public Integer getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(Integer currentNo) {
        if(currentNo > 0){
            this.currentNo = currentNo;
        }
    }

    public Integer getPagetotalCount() {
        return pagetotalCount;
    }

    public void setPagetotalCount(Integer pagetotalCount) {
        this.pagetotalCount = pagetotalCount;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getPageCount() {
        return PageCount;
    }

    public void setPageCount(Integer pageCount) {
        PageCount = pageCount;
        if(pageCount > 0){
            this.pagetotalCount = pageCount % this.PageSize == 0 ? pageCount / this.PageSize : pageCount / this.PageSize + 1 ;
        }
    }
}
