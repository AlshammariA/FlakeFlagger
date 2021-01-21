@Test public void zeros() throws IOException {
  shouldCompileTo("num1: {{num1}}, num2: {{num2}}","{num1: 42, num2: 0}","num1: 42, num2: 0");
  shouldCompileTo("num: {{.}}","0","num: 0");
  shouldCompileTo("num: {{num1/num2}}","{num1: {num2: 0}}","num: 0");
}
