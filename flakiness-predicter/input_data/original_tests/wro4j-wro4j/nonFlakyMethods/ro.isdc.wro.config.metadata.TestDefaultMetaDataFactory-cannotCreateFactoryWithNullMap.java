@Test(expected=NullPointerException.class) public void cannotCreateFactoryWithNullMap(){
  new DefaultMetaDataFactory(null);
}
