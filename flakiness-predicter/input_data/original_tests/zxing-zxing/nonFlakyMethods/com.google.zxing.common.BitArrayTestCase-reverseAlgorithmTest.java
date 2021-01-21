@Test public void reverseAlgorithmTest(){
  int[] oldBits={128,256,512,6453324,50934953};
  for (int size=1; size < 160; size++) {
    int[] newBitsOriginal=reverseOriginal(oldBits.clone(),size);
    BitArray newBitArray=new BitArray(oldBits.clone(),size);
    newBitArray.reverse();
    int[] newBitsNew=newBitArray.getBitArray();
    assertTrue(arraysAreEqual(newBitsOriginal,newBitsNew,size / 32 + 1));
  }
}
