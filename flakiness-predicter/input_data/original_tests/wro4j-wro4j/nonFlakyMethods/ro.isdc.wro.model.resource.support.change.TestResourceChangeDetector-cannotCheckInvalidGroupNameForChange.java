@Test(expected=NullPointerException.class) public void cannotCheckInvalidGroupNameForChange() throws Exception {
  victim.checkChangeForGroup("resource",null);
}
