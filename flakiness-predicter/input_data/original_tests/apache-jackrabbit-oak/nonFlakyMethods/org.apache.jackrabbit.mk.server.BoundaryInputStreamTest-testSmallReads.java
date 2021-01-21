/** 
 * Create a very small boundary input stream, where the boundary will be split between two reads.
 */
public void testSmallReads() throws Exception {
  byte[] content=new byte[1024];
  RANDOM.nextBytes(content);
  ByteArrayOutputStream out=new ByteArrayOutputStream();
  out.write(content);
  out.write("\r\n".getBytes());
  out.write(BOUNDARY.getBytes());
  byte[] noise=new byte[content.length];
  RANDOM.nextBytes(noise);
  out.write(noise);
  BoundaryInputStream in=new BoundaryInputStream(new ByteArrayInputStream(out.toByteArray()),BOUNDARY,1);
  out=new ByteArrayOutputStream(8192);
  IOUtils.copy(in,out);
  byte[] result=out.toByteArray();
  assertEquals(content.length,result.length);
  assertTrue(Arrays.equals(content,result));
}
