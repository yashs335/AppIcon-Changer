import 'package:app_icon_changer/app_icon_changer.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text('Plugin example app')),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              IconButton(
                icon: Icon(Icons.one_k),
                onPressed: () => AppIconChanger.setIcon('one'),
              ),
              const SizedBox(height: 20),
              IconButton(
                icon: Icon(Icons.two_k),
                onPressed: () => AppIconChanger.setIcon('two'),
              ),
              const SizedBox(height: 20),
              IconButton(
                icon: Icon(Icons.three_k),
                onPressed: () => AppIconChanger.setIcon('default'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
