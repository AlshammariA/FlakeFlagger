@Test(expected=NullPointerException.class) public void cannotUseNullFilterConfig(){
  ServletContextAttributeHelper.create(null);
}
