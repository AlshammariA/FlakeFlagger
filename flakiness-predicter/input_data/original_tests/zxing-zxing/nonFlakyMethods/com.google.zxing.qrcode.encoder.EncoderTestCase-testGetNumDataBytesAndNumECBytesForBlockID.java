@Test public void testGetNumDataBytesAndNumECBytesForBlockID() throws WriterException {
  int[] numDataBytes=new int[1];
  int[] numEcBytes=new int[1];
  Encoder.getNumDataBytesAndNumECBytesForBlockID(26,9,1,0,numDataBytes,numEcBytes);
  assertEquals(9,numDataBytes[0]);
  assertEquals(17,numEcBytes[0]);
  Encoder.getNumDataBytesAndNumECBytesForBlockID(70,26,2,0,numDataBytes,numEcBytes);
  assertEquals(13,numDataBytes[0]);
  assertEquals(22,numEcBytes[0]);
  Encoder.getNumDataBytesAndNumECBytesForBlockID(70,26,2,1,numDataBytes,numEcBytes);
  assertEquals(13,numDataBytes[0]);
  assertEquals(22,numEcBytes[0]);
  Encoder.getNumDataBytesAndNumECBytesForBlockID(196,66,5,0,numDataBytes,numEcBytes);
  assertEquals(13,numDataBytes[0]);
  assertEquals(26,numEcBytes[0]);
  Encoder.getNumDataBytesAndNumECBytesForBlockID(196,66,5,4,numDataBytes,numEcBytes);
  assertEquals(14,numDataBytes[0]);
  assertEquals(26,numEcBytes[0]);
  Encoder.getNumDataBytesAndNumECBytesForBlockID(3706,1276,81,0,numDataBytes,numEcBytes);
  assertEquals(15,numDataBytes[0]);
  assertEquals(30,numEcBytes[0]);
  Encoder.getNumDataBytesAndNumECBytesForBlockID(3706,1276,81,20,numDataBytes,numEcBytes);
  assertEquals(16,numDataBytes[0]);
  assertEquals(30,numEcBytes[0]);
  Encoder.getNumDataBytesAndNumECBytesForBlockID(3706,1276,81,80,numDataBytes,numEcBytes);
  assertEquals(16,numDataBytes[0]);
  assertEquals(30,numEcBytes[0]);
}
