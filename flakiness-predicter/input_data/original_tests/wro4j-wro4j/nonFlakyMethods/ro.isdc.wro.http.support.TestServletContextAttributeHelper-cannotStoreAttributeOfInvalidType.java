@Test(expected=IllegalArgumentException.class) public void cannotStoreAttributeOfInvalidType(){
  victim.setAttribute(Attribute.MANAGER_FACTORY,"invalid type");
}
