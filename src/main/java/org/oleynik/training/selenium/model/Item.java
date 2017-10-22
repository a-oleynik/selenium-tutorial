package org.oleynik.training.selenium.model;

public class Item {
    private String title;
    private String campaignPrice;
    private String regularPrice;

    public Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCampaignPrice() {
        return campaignPrice;
    }

    public void setCampaignPrice(String campaignPrice) {
        this.campaignPrice = campaignPrice;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!title.equals(item.title)) return false;
        if (campaignPrice != null ? !campaignPrice.equals(item.campaignPrice) : item.campaignPrice != null) return false;
        return regularPrice != null ? regularPrice.equals(item.regularPrice) : item.regularPrice == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (campaignPrice != null ? campaignPrice.hashCode() : 0);
        result = 31 * result + (regularPrice != null ? regularPrice.hashCode() : 0);
        return result;
    }
}
