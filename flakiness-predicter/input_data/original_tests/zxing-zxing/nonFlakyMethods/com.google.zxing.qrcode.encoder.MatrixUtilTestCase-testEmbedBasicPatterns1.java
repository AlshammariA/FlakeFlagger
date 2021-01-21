@Test public void testEmbedBasicPatterns1() throws WriterException {
  ByteMatrix matrix=new ByteMatrix(21,21);
  MatrixUtil.clearMatrix(matrix);
  MatrixUtil.embedBasicPatterns(Version.getVersionForNumber(1),matrix);
  String expected=" 1 1 1 1 1 1 1 0           0 1 1 1 1 1 1 1\n" + " 1 0 0 0 0 0 1 0           0 1 0 0 0 0 0 1\n" + " 1 0 1 1 1 0 1 0           0 1 0 1 1 1 0 1\n"+ " 1 0 1 1 1 0 1 0           0 1 0 1 1 1 0 1\n"+ " 1 0 1 1 1 0 1 0           0 1 0 1 1 1 0 1\n"+ " 1 0 0 0 0 0 1 0           0 1 0 0 0 0 0 1\n"+ " 1 1 1 1 1 1 1 0 1 0 1 0 1 0 1 1 1 1 1 1 1\n"+ " 0 0 0 0 0 0 0 0           0 0 0 0 0 0 0 0\n"+ "             1                            \n"+ "             0                            \n"+ "             1                            \n"+ "             0                            \n"+ "             1                            \n"+ " 0 0 0 0 0 0 0 0 1                        \n"+ " 1 1 1 1 1 1 1 0                          \n"+ " 1 0 0 0 0 0 1 0                          \n"+ " 1 0 1 1 1 0 1 0                          \n"+ " 1 0 1 1 1 0 1 0                          \n"+ " 1 0 1 1 1 0 1 0                          \n"+ " 1 0 0 0 0 0 1 0                          \n"+ " 1 1 1 1 1 1 1 0                          \n";
  assertEquals(expected,matrix.toString());
}
