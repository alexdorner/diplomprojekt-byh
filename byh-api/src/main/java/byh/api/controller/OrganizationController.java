package byh.api.controller;

import FhirModel.*;
import Impl.DepartmentMapperImpl;
import KisModel.MedicalDepartmentK;
import mapper.DepartmentMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(path = "/api/organization")
@CrossOrigin
public class OrganizationController {



}
