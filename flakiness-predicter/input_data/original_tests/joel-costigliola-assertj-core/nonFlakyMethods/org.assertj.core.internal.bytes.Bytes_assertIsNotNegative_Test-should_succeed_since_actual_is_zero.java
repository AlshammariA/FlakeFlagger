@Test public void should_succeed_since_actual_is_zero(){
  bytes.assertIsNotNegative(someInfo(),(byte)0);
}
