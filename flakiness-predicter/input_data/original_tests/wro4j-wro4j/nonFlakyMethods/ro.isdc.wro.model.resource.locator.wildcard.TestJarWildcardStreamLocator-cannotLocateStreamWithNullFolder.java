@Test(expected=NullPointerException.class) public void cannotLocateStreamWithNullFolder() throws Exception {
  jarStreamLocator.locateStream("",null);
}
