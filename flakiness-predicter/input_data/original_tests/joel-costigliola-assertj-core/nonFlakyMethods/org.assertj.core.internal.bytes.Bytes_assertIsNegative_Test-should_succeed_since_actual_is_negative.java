@Test public void should_succeed_since_actual_is_negative(){
  bytes.assertIsNegative(someInfo(),(byte)-6);
}
