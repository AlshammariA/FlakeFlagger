@Test(expected=NullPointerException.class) public void cannotCheckInvalidUriForChange() throws Exception {
  victim.checkChangeForGroup(null,GROUP1_NAME);
}
