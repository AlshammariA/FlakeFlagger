@Test public void random(){
  for (int i=0; i < 100000; i++) {
    int rOffset=random.nextInt(BA_SIZE - 4);
    int rInt=random.nextInt();
    verifyLoop(byteArray,rOffset,rInt);
  }
}
