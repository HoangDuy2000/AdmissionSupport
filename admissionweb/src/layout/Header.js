import { useEffect, useState } from "react";
import { Button, Col, Container, Form, Nav, NavDropdown, Navbar, Row, Spinner } from "react-bootstrap";
import Apis, { endpoint } from "../configs/Apis";
import { useNavigate } from "react-router-dom";

const Header = () => {
    const [typenews, setTypeNews] = useState(null);
    const [kw, setKw] = useState();
    const nav = useNavigate();

    useEffect(() => {
        const loadTypeNews = async() => {
            let res = await Apis.get(endpoint['typenews'])
            setTypeNews(res.data);
        }

        loadTypeNews();
    }, []);

    const search = (evt) =>{
        evt.preventDefault();
        nav(`/news?kw=${kw}`);
    }

    if (typenews === null)
        return <Spinner animation="border" variant="primary" />;

    return <>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">Admission Website</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                <Nav.Link href="#home">Trang Chủ</Nav.Link>
                <NavDropdown title="Tin Tuyển Sinh" id="basic-nav-dropdown">
                    {typenews.map(type => <NavDropdown.Item key={type.id} href="#action/3.1">{type.name}</NavDropdown.Item>)}
                </NavDropdown>
                <Nav.Link href="#home">Thông Tin Khoa</Nav.Link>
                <NavDropdown title="Tư Vấn Tuyển Sinh" id="basic-nav-dropdown">
                    <NavDropdown.Item href="#action/3.1">Lịch livestream</NavDropdown.Item>
                    <NavDropdown.Item href="#action/3.1">Câu Hỏi Thường Gặp</NavDropdown.Item>
                </NavDropdown>
                <Nav.Link href="#link">Đăng Nhập</Nav.Link>
                </Nav>
                </Navbar.Collapse>
                <Form inline onSubmit={search}>
                    <Row>
                    <Col xs="auto">
                        <Form.Control
                        type="text"
                        value={kw}
                        onChange={e => setKw(e.target.value)}
                        placeholder="Nhập tên tin tuyển sinh..."
                        className=" mr-sm-2"
                        />
                    </Col>
                    <Col xs="auto">
                        <Button type="submit">Tìm</Button>
                    </Col>
                    </Row>
                </Form>
            </Container>
        </Navbar>
    </>
}

export default Header;