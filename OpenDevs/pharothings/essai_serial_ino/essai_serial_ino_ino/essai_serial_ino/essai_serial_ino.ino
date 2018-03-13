int counter = 0;

void setup() {
    pinMode(LED_BUILTIN, OUTPUT);
    Serial.begin(9600);
}
void loop() {
    Serial.print("Hello, world!  ");
    Serial.println(counter);
    digitalWrite(LED_BUILTIN, HIGH);
    delay(500);
    digitalWrite(LED_BUILTIN, LOW);
    delay(2000);
    counter++ ;
}
