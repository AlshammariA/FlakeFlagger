@Test public void should_succeed_since_actual_is_not_zero(){
  bytes.assertIsNotZero(someInfo(),(byte)2);
}
