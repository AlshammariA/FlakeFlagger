@Test(expected=NullPointerException.class) public void cannotMergeNullModel(){
  victim.merge(null);
}
