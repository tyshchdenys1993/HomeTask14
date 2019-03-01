package com.aqacourses.project.enums;

public enum Categories {
    WOMEN("Women", "http://automationpractice.com/index.php?id_category=3&controller=category"),
    TOPS("Tops", "http://automationpractice.com/index.php?id_category=4&controller=category"),
    TSHIRTS(
            "T-shirts",
            "http://automationpractice.com/index.php?id_category=5&controller=category"),
    DRESSES("Dresses", "http://automationpractice.com/index.php?id_category=8&controller=category"),
    CASUAL_DRESSES(
            "Casual Dresses",
            "http://automationpractice.com/index.php?id_category=9&controller=category"),
    EVENING_DRESSES(
            "Evening Dresses",
            "http://automationpractice.com/index.php?id_category=10&controller=category"),
    SUMMER_DRESSES(
            "Summer Dresses",
            "http://automationpractice.com/index.php?id_category=11&controller=category");

    private String categoryName;
    private String categoryLink;

    /**
     * Constructor
     * @param categoryName
     * @param categoryLink
     */
    Categories(String categoryName, String categoryLink) {
        this.categoryName = categoryName;
        this.categoryLink = categoryLink;
    }

    /**
     * Category name getter
     *
     * @return categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Category link getter
     *
     * @return categoryLink
     */
    public String getCategoryLink() {
        return categoryLink;
    }
}
