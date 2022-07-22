package ss16_io_text.exercise.read_file_csv.controller;

import ss16_io_text.exercise.read_file_csv.service.impl.NationService;

public class MainController {
    public static void menu() {
        NationService nationService=new NationService();
        nationService.display(nationService.getNations());
    }
}
