package com.itcast.domain;

public class Pages {
    private Integer pageCounts;//每页显示条目数
    private Integer pageNum;//当前页页码
    private Integer startNum;//每页起始记录
    private Integer counts;//总记录数
    private Integer pages;//总页数

    @Override
    public String toString() {
        return "Pages{" +
                "pageCounts=" + pageCounts +
                ", pageNum=" + pageNum +
                ", startNum=" + startNum +
                ", counts=" + counts +
                ", pages=" + pages +
                '}';
    }

    public Integer getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(Integer pageCounts) {
        this.pageCounts = pageCounts;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
