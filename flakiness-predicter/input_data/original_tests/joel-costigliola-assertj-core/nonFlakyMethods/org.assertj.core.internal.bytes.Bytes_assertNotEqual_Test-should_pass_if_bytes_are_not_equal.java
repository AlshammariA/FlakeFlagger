@Test public void should_pass_if_bytes_are_not_equal(){
  bytes.assertNotEqual(someInfo(),(byte)8,(byte)6);
}
