@Test(expected=NullPointerException.class) public void cannotAcceptNullArgument(){
  SchedulerHelper.create(null);
}
