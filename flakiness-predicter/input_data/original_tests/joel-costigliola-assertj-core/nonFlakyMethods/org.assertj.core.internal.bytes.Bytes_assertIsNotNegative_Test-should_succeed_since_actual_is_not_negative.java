@Test public void should_succeed_since_actual_is_not_negative(){
  bytes.assertIsNotNegative(someInfo(),(byte)6);
}
