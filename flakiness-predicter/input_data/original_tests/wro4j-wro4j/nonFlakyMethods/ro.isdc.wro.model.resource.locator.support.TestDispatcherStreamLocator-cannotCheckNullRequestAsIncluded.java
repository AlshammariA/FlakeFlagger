@Test(expected=NullPointerException.class) public void cannotCheckNullRequestAsIncluded(){
  DispatcherStreamLocator.isIncludedRequest(null);
}
