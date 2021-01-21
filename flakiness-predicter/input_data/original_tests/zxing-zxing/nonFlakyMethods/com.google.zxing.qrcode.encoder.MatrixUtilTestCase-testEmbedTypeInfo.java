@Test public void testEmbedTypeInfo() throws WriterException {
  ByteMatrix matrix=new ByteMatrix(21,21);
  MatrixUtil.clearMatrix(matrix);
  MatrixUtil.embedTypeInfo(ErrorCorrectionLevel.M,5,matrix);
  String expected="                 0                        \n" + "                 1                        \n" + "                 1                        \n"+ "                 1                        \n"+ "                 0                        \n"+ "                 0                        \n"+ "                                          \n"+ "                 1                        \n"+ " 1 0 0 0 0 0   0 1         1 1 0 0 1 1 1 0\n"+ "                                          \n"+ "                                          \n"+ "                                          \n"+ "                                          \n"+ "                                          \n"+ "                 0                        \n"+ "                 0                        \n"+ "                 0                        \n"+ "                 0                        \n"+ "                 0                        \n"+ "                 0                        \n"+ "                 1                        \n";
  assertEquals(expected,matrix.toString());
}
