package org.example.datastructures1;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.*;

public class Main extends Application {
    private DataStructure<String> dataStructure;
    private TextArea fileContentArea;
    private TextArea convertedDataArea;
    private List<String> importedData = new ArrayList<>();
    private TextField searchField;
    private Label searchResult;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Data Structures & Algorithms");

        // UI Components
        Button importButton = new Button("Upload CSV");
        fileContentArea = new TextArea();
        fileContentArea.setEditable(false);
        fileContentArea.setPromptText("CSV content will appear here...");

        ComboBox<String> structureComboBox = new ComboBox<>();
        structureComboBox.getItems().addAll("ArrayList", "LinkedList", "Binary Search Tree");

        Button convertButton = new Button("Convert to Data Structure");
        convertedDataArea = new TextArea();
        convertedDataArea.setEditable(false);
        convertedDataArea.setPromptText("Converted data will appear here...");

        // Sorting & Searching Controls
        ComboBox<String> sortComboBox = new ComboBox<>();
        sortComboBox.getItems().addAll("Bubble Sort", "Quick Sort");
        Button sortButton = new Button("Sort Data");

        searchField = new TextField();
        searchField.setPromptText("Enter value to search");
        ComboBox<String> searchComboBox = new ComboBox<>();
        searchComboBox.getItems().addAll("Linear Search", "Binary Search");
        Button searchButton = new Button("Search");

        searchResult = new Label("Search results will appear here...");

        // Layout
        VBox layout = new VBox(10, importButton, fileContentArea, structureComboBox, convertButton, convertedDataArea,
                sortComboBox, sortButton, searchField, searchComboBox, searchButton, searchResult);
        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);

        // Button Actions
        importButton.setOnAction(e -> uploadCSV(primaryStage));
        convertButton.setOnAction(e -> convertDataStructure(structureComboBox.getValue()));
        sortButton.setOnAction(e -> sortData(sortComboBox.getValue()));
        searchButton.setOnAction(e -> searchData(searchComboBox.getValue()));

        primaryStage.show();
    }

    private void uploadCSV(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            importedData.clear();
            fileContentArea.clear();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    importedData.add(line);
                    fileContentArea.appendText(line + "\n");
                }
            } catch (IOException e) {
                fileContentArea.setText("Error reading file!");
                e.printStackTrace();
            }
        }
    }

    private void convertDataStructure(String structureType) {
        if (structureType == null || importedData.isEmpty()) return;

        switch (structureType) {
            case "ArrayList":
                dataStructure = new ArrayListStructure<>();
                break;
            case "LinkedList":
                dataStructure = new LinkedListStructure<>();
                break;
            case "Binary Search Tree":
                dataStructure = new BinarySearchTreeStructure<>();
                break;
        }

        for (String line : importedData) {
            String[] values = line.split(","); // Assuming CSV is comma-separated
            for (String value : values) {
                dataStructure.add(value.trim());
            }
        }

        convertedDataArea.setText(dataStructure.toString());
    }

    private void sortData(String sortType) {
        if (dataStructure == null) return;

        Sorting<String> sortingAlgorithm;
        switch (sortType) {
            case "Bubble Sort":
                sortingAlgorithm = new BubbleSort<>();
                break;
            case "Quick Sort":
                sortingAlgorithm = new QuickSort<>();
                break;
            default:
                return;
        }

        sortingAlgorithm.sort(dataStructure);
        convertedDataArea.setText("Sorted Data:\n" + dataStructure);
    }

    private void searchData(String searchType) {
        if (dataStructure == null || searchField.getText().isEmpty()) return;

        String searchValue = searchField.getText();
        Search<String> searchAlgorithm;

        switch (searchType) {
            case "Linear Search":
                searchAlgorithm = new LinearSearch<>();
                break;
            case "Binary Search":
                // Binary search only works on index-accessible and sorted structures
                if (dataStructure instanceof BinarySearchTreeStructure) {
                    searchResult.setText("Binary Search is not supported on Binary Search Trees.");
                    return;
                }
                searchAlgorithm = new BinarySearch<>();
                break;
            default:
                searchResult.setText("Please select a valid search algorithm.");
                return;
        }

        String result = searchAlgorithm.search(dataStructure, searchValue);
        searchResult.setText(result);
    }
}