@Test(expected=NullPointerException.class) public void cannotExtractResourceTypeUsingNullUri(){
  victim.getResourceType(null);
}
