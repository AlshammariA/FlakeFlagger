@Test(expected=NullPointerException.class) public void cannotBuildCacheKeyFromNullRequest(){
  victim.create(null);
}
