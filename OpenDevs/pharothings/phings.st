""
baudRate := 9600.
comPortNumber := '/dev/ttyACM0'. "COM6 for me, taken from my Arduino IDE config"
myPort :=
    SerialPort new
        baudRate: baudRate;
        dataBits: 8;
        stopBitsType: 1;
        parityType: 0;
        yourself.
(myPort openPort: comPortNumber) isNil ifFalse: [ myPort inspect ].


Transcript open.
bytesRead := 0.
buffer := String new: 1000.
d := Delay forMilliseconds: 300.
timeout := 5000. "milliseconds"
started := Time millisecondClockValue.
[ Time millisecondClockValue - started < timeout ]
whileTrue:
	[
		nRead := myPort readInto: buffer startingAt: bytesRead + 1.
		nRead isZero
			ifTrue: [ d wait ]
			ifFalse: [bytesRead := bytesRead + nRead].
	].
Transcript crShow: (buffer trimRight: [ :c | c = Character null]).
