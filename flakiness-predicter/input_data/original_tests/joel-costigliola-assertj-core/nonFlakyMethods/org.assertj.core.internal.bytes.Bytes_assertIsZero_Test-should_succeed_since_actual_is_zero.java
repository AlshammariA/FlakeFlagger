@Test public void should_succeed_since_actual_is_zero(){
  bytes.assertIsZero(someInfo(),(byte)0x00);
}
